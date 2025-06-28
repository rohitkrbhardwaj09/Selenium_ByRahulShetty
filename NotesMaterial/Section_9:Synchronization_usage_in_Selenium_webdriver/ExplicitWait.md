<h4> There is another explicit wait mechanism type called <b>Fluent wait</b>.</h4>

Explicit wait can be acheive in 2 ways
1: WebDriverWait = 10 second
2: FluentWait = 10 Second, Polling 2 second

### How different it is from WebDriver Wait? timeout=10 seconds

Fluent wait finds the web element repeatedly at regular intervals of time until the timeout or till the object gets found.

Unlike WebDriver Wait, we need to build customized wait methods based on condition

Both WebDriverWait and FluentWait classes implement Wait interface.