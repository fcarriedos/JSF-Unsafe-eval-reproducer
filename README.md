1. Checkout
2. Build with `mvn clean package -Dcheckstyle.skip`
3. Deploy reproducer-04209988.war to JBoss EAP 8+
4. Browse localhost:8080/reproducer-04209988/mytest.jsf
5. Open the developer tools, console tab.
6. Click on the `Click Me` link.
7. Observe the CSP violation, indicating that `unsafe-eval` is needed.
