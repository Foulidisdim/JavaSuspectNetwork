# JavaSuspectNetwork

JavaSuspectNetwork is a simple Java-based application that simulates a criminal investigation system. It models suspects, their communications, and their social network using a basic GUI and visualization tools.

## 📌 Features

- Model suspects with personal and location data
- Store and analyze communications (Phone Calls & SMS)
- Detect suspicious messages via keyword scanning
- Visualize suspect connections as a network graph
- Interactive GUI for searching and exploring suspect details

## 🧠 How It Works

Suspects are manually added into the system and tracked via their registered phone numbers. Communications (calls and SMS) are logged between phone numbers, and relationships are inferred based on those interactions.

### 🔗 When Are Suspects Connected?

Two suspects are considered **connected (related/partners)** if:
- They have communicated via **phone call** or **SMS**
- The communication occurs **between any of their registered phone numbers**

The connection is **bidirectional**, meaning if A is connected to B, B is also connected to A.

#### 🧬 Example:
- Suspect A owns number `123`
- Suspect B owns number `456`
- A phone call or SMS occurs between `123` and `456`  
➡️ Then A and B are marked as **partners** in the network

Indirect connections (like friends-of-friends) are also calculated using the `suggestedPartners()` method.

## 📊 Network Visualization

The app uses Sava Swing for the GUI and the JUNG library to create an interactive graph layout:
- **Nodes**: Suspects
- **Edges**: Communication links
- **Graph View**: Circular layout showing connections

## 🖥️ GUI Overview

- **FindSuspect**: Search for a suspect by name
- **SuspectPage**: View detailed info, SMS analysis, and partner list
- **Suspectsnetwork**: Visual network graph of the suspect web

## 📂 Project Structure

```
src/
├── Main.java               # Program entry point
├── Suspect.java            # Suspect model
├── Communication.java      # Abstract communication class
├── PhoneCall.java          # Phone call class
├── SMS.java                # SMS message class
├── Registry.java           # Stores all suspects and communications
├── FindSuspect.java        # Search GUI
├── SuspectPage.java        # Detailed suspect info GUI
└── Suspectsnetwork.java    # Visualizes the suspect network
```

## 🚀 Getting Started

1. Clone the repo:
   ```bash
   git clone https://github.com/Foulidisdim/JavaSuspectNetwork.git
   ```

2. Open in [Eclipse IDE](https://www.eclipse.org/) (project includes `.project` and `.classpath` files)

3. Run `Main.java` to launch the program.

## ✅ Requirements

- Java 8+
- Eclipse (optional, for easier GUI config)
- [JUNG (Java Universal Network/Graph Framework)](http://jung.sourceforge.net/) library

## 📄 License

This project is open-source and available under the MIT License. It is developed for educational purposes and is not intended for commercial use.
