## Deploying Java API application into AWS environment
This application is going to deploy the code into AWS environment by creating the build environment and pipeline from the GitHub repository then deploy the code into EC2 instance. Also create the `buildspec.yml` file to define the steps to compile and deploy the code and this build pipeline will be executed for any changes happened to the GitHub repository as well as deploy the latest code changes into the EC2 instance to immediately reflect the changes while accessing the API endpoints.

### Creating spring-boot web application
- Create the `order-service` spring-boot application
- Run the application in your local environment and make sure the application was running as expected
- This spring-boot web application was exposed through http://localhost:5000 url
- The API exposed from this web-application as
  - `/orders` -- it will list out the product list which was ordered
  - `/orders/sorted` -- it will list out the product based on price in ascending order

If above steps are done then we are good to proceed with next step.
  
### Check-in the code changes into GitHub
- The project code changes you can directly check-in to the GitHub repository. This can be done from IDE or through terminal
  - IDE provide the way to add the files to the GitHub repository then add the commit message to check-in the changes
  - From the terminal
    - We need to create the new `order-service` repository then checkout the same to our local repository
    - Then add the above code then `git add .` to add all changes
    - Then execute the `git commit -n "message"` to commit the changes
  - Finally, verify all our code changes are sync with GitHub remote repository

### Configuring the CodeBuild and Deployment to AWS
- Configure Code Build pipeline configuration
  - Login to `AWS console` and search for `Code Pipeline` and select to configure the code pipeline
  - Given the new code pipeline name and leave all other values as default. If required then change the same
  - Click on next and choose `GitHub` is your source provider and connect to GitHub and enter your credential to enable
  - Select the specific repository to choose for build and select the branch will be `master` and also choose `GitHub Webhooks`
  - Select the `Build Provider` as `AWS CodeBuild` and select the default region
    - Create the new project for build pipeline by giving the name of the project as `orderService` and `os` is `Amazon Linux2` or `Ubuntu` and `Runtime` as `standard`
    - Select the latest image and select the Build Spec as `Use a build-spec file` (as we already created inside the project)
    - Then click on `Continue to CodePipeline`
- Configure Elastic Beanstalk configuration

### Validating changes deploy to AWS 