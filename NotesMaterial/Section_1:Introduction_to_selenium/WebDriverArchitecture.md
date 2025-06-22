![image](https://github.com/user-attachments/assets/f2a94c52-8d29-41e2-baa7-96ba47bcb53b)

- After you trigger the Test, complete Selenium code (Client) which we have written   will be converted to Json format 
- Generated Json is sent to Browser Driver (Server) through http Protocol 
- Note: Each browser contains a separate browser driver 
- Browser drivers communicate with its respective browser and executes the commands by interpreting Json which It received on the browser. 
- Browser Driver receives responses back from the browser and it sends Json response back to Client.

## And This is the older way