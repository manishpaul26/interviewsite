## What has been done-

- The Contact us component has been built. 
- On submission, AEM servlet is invoked using a POST request. The servlet internally invokes other services.
- Image component has been fixed using the correct Sling Delegation Model pattern
- Image dialog uses minimal xml and implements Sling Resource Merger concept
- Basic Frontend code has been added to trigger Ajax response on submission of form
- JUnits have been written for all services and servlets
- WCM Mocks have been used for Junits
- Sample content and images have been added to the codebase and the filters have been updated to replace to ensure correct content is deployed.


## Demo pages-

http://localhost:4502/editor.html/content/interviewsite/us/en/image-demo-page.html
http://localhost:4502/content/interviewsite/us/en/contact-us-page.html


## Main Project Files-


- core ->
    - Image Implementation - https://github.com/manishpaul26/interviewsite/blob/master/core/src/main/java/com/mysite/core/models/ImageImpl.java
    - Salesforce Service - https://github.com/manishpaul26/interviewsite/blob/master/core/src/main/java/com/mysite/core/services/SalesforceServiceImpl.java
    - HTTP Client Service - https://github.com/manishpaul26/interviewsite/blob/master/core/src/main/java/com/mysite/core/services/HttpClientServiceImpl.java
    - Contact us servlet - https://github.com/manishpaul26/interviewsite/blob/master/core/src/main/java/com/mysite/core/servlets/ContactUsServlet.java
    - Image Sling Model - https://github.com/manishpaul26/interviewsite/blob/master/core/src/main/java/com/mysite/core/models/ImageImpl.java
    - Some beans - https://github.com/manishpaul26/interviewsite/tree/master/core/src/main/java/com/mysite/core/beans

- Tests ->
    - https://github.com/manishpaul26/interviewsite/tree/master/core/src/test/java/com/mysite/core/services
    - https://github.com/manishpaul26/interviewsite/tree/master/core/src/test/java/com/mysite/core/servlets
    - https://github.com/manishpaul26/interviewsite/tree/master/core/src/test/java/com/mysite/core/models


- Apps ->
    - /apps/interviewsite/components/image
    - /apps/interviewsite/components/contactus

- Image Dialog-
    - https://github.com/manishpaul26/interviewsite/tree/master/ui.apps/src/main/content/jcr_root/apps/interviewsite/components/image/_cq_dialog



- Front end files-
    - https://github.com/manishpaul26/interviewsite/blob/master/ui.frontend/src/main/webpack/components/contactus.js




### Project has now been built for cloud sdk using archetype 35




## If JUnits fail in Intellij because of gson-

Open Module Settings by right clicking on the project, go to Libraries. Search for gson, right click -> Add to Modules -> code. This should fix any `NoClassDefFound` exceptions.


## Screenshots-

### Contact us-
![alt text](https://github.com/manishpaul26/interviewsite/blob/master/screenshots/contact-us.png)


### Image Dialog
![alt text](https://github.com/manishpaul26/interviewsite/blob/master/screenshots/thumbnail-image.png)


## Modules

The main parts of the template are:

* core: Java bundle containing all core functionality like OSGi services, listeners or schedulers, as well as component-related Java code such as servlets or request filters.
* it.tests: Java based integration tests
* ui.apps: contains the /apps (and /etc) parts of the project, ie JS&CSS clientlibs, components, and templates
* ui.content: contains sample content using the components from the ui.apps
* ui.config: contains runmode specific OSGi configs for the project
* ui.frontend: an optional dedicated front-end build mechanism (Angular, React or general Webpack project)
* ui.tests: Selenium based UI tests
* all: a single content package that embeds all of the compiled modules (bundles and content packages) including any vendor dependencies
* analyse: this module runs analysis on the project which provides additional validation for deploying into AEMaaCS

## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

Or to deploy only a single content package, run in the sub-module directory (i.e `ui.apps`)

    mvn clean install -PautoInstallPackage


