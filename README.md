# risiko

This is a multi-player version of "Risiko!" game written with Java RMI. It is intended to be used with a VPN (e.g. Hamachi) to which each player is connected.

The system is client-server and the communication between client and server is bidirectional. Each player must have the client installed on his machine. One of the players must also host the server to which each client will connect. Both the server and client are shipped as Jar files.

In order for the game to start, the server must run and set before each client attempts to connect. After the server is ready, each player can start his client, connect it to the server and play.
