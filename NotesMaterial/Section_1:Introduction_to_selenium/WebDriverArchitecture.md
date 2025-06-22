
## Older way is -

![image](https://github.com/user-attachments/assets/f2a94c52-8d29-41e2-baa7-96ba47bcb53b)

- After you trigger the Test, complete Selenium code (Client) which we have written   will be converted to Json format 
- Generated Json is sent to Browser Driver (Server) through http Protocol 
- Note: Each browser contains a separate browser driver 
- Browser drivers communicate with its respective browser and executes the commands by interpreting Json which It received on the browser. 
- Browser Driver receives responses back from the browser and it sends Json response back to Client.

# Newer way is -
![image](https://github.com/user-attachments/assets/71e27548-4b59-452c-8330-da21e37986a3)

- The WebDriver client translates the commands from your script into **HTTP requests** following the **W3C WebDriver Protocol**.
- **Why W3C WebDriver Protocol** (https://www.w3.org/TR/webdriver1/#navigate-to)
  - All modern browsers (Chrome, Firefox, Safari, Edge) natively supports the W3C protocol, ensuring consistent behavior
- These Http requests are sent to Browser Drivers
  - **What is Browser Driver?**
    - Each browser (Chrome, Firefox, Safari, etc.) has its own dedicated driver. This driver is a small program that acts as a translator between the WebDriver protocol and the browser itself.
- Finally, the browser drivers interprest the http requests and control the actual web browser, carring out the actions your test scripts define (opening pages, clicking button, filling forms etc.).
- The browser executes the commands and returns the response to the driver, which is relayed back to the WebDriver client.
