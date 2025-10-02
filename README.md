# Multi-threaded Server with Blocking I/O

This project implements a simple **multi-threaded server** using **blocking I/O** in Java.  

## Overview
- The server listens on port **1234**.  
- When a client connects, the server creates a new thread (`Converstation`) to handle communication with that client.  
- Each client gets a unique ID number.  
- Communication is handled with **blocking I/O** (`BufferedReader` for input and `PrintWriter` for output).  

## Features
- Supports multiple clients at the same time.  
- Each client receives a welcome message:  
  `hello you are the client number X`  
- For every message sent by the client, the server responds with its length:  
  `longeur est <message_length>`  
- The server logs all connections and messages in the console, including the client’s IP address.  

## How it Works
1. **ServerMT**:  
   - Opens a `ServerSocket` on port 1234.  
   - Waits for clients (`accept()`).  
   - Starts a new `Converstation` thread for each client.  

2. **Converstation**:  
   - Reads input from the client.  
   - Prints the client’s messages to the console.  
   - Sends a response with the message length.  

## Example
- Client connects → Server prints:  
  `Client 1 is connected with ip: /127.0.0.1:54321`  
- Client sends:  
  `hello`  
- Server responds:  
  `longeur est 5`  

---
