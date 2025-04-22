import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.shortestpath.DistanceStatistics;
import edu.uci.ics.jung.graph.UndirectedGraph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;


public class Suspectsnetwork extends JFrame{

	private JPanel panel = new JPanel();
	private JTextField diameterField = new JTextField();
	
	public Suspectsnetwork(Registry aRegistry) {
		
		UndirectedGraph<String, String> g = new UndirectedSparseGraph<String, String>(); //dhmiourgia grafou me kombous suspect
		//OXI SparseMultigraph. SKETO SparseGraph GIATI THELO MONO MIA FORA NA MPEI H KATHE AKMH. to multi kanei parallel edges.
		
		for(Suspect suspect : aRegistry.Suspects) {
			g.addVertex(suspect.getCodeName()); //prosthiki ton kombon suspect. BAZO TA CODENAME GIATI OS LABEL KATHE KOMBOU THELEI TA CODENAMES.
		}
		//edo eksetazo suspects kai oxi apla codenames gia na balo tis akmes sosta.
		for(Suspect suspect : aRegistry.Suspects) {
			for(Suspect partners : suspect.getPartners()) 
					g.addEdge(suspect.getCodeName() + " - " + partners.getCodeName(),suspect.getCodeName(), partners.getCodeName()); //prosthiki ton akmon.
		}
		
		
        //RYTHMISI OPTIKOPOIHSHS GRAFOU:
		// The Layout<V, E> is parameterized by the vertex and edge types
		Layout<String, String> layout = new CircleLayout(g); //xrhsimopoioume to graph pou kaname pio pano.
		layout.setSize(new Dimension(300,300)); // sets the initial size of the space
		// The BasicVisualizationServer<V,E> is parameterized by the edge types
		BasicVisualizationServer<String,String> visual = new BasicVisualizationServer<String,String>(layout);
		visual.getRenderContext().setVertexLabelTransformer(new ToStringLabeller()); //GIA NA EMFANISTOUN TA ONOMATA DIPLA STOUS KOMBOUS.
		visual.setPreferredSize(new Dimension(380,350)); //Sets the viewing area size
		
		diameterField.setText("Diameter: " + DistanceStatistics.diameter(g)); // BRISKEI TH DIAMETRO TOU GRAFOU KAI TH BAZEI STO TEXTFIELD.
		
        panel.add(visual);
        panel.add(diameterField);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS)); //gia na mpei to textfield ths diametrou kato apo thn optikopoihsh.
        this.setContentPane(panel); //sto parathiro tha emfanistei to panel pou sxediasa pano pou exei thn optikopoihsh.
        
        setVisible(true); //kathista to parathiro orato.
        pack(); //sizes the frame so that all its contents are at or above their preferred sizes!
		setTitle("Suspects Network"); //titlos parathirou.
		setLocationRelativeTo(null); // GIA NA EMFANIZETAI STO KENTRO TO PARATHIRO
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
