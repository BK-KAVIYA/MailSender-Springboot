# Spring Boot Email Sender

This Spring Boot application sends HTML emails using Google SMTP. The email content includes a default HTML template with interactive elements like a button that redirects to `www.kavinda.me`.

## Features

- Send HTML emails using Google SMTP.
- Load email templates from resource files.
- Configurable email properties via `application.properties`.

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- A Google account for SMTP configuration

## Getting Started

### Clone the repository

```bash
https://github.com/BK-KAVIYA/MailSender-Springboot.git
```
### Configure application properties
Edit the src/main/resources/application.properties file to include your email configuration:

```bash
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000

# Set the 'from' email address
myapp.email.from=your-email@gmail.com
```
### Google Account Configuration
To use your Google account for sending emails, you may need to enable "Less secure app access" or use App Passwords if you have 2-Step Verification enabled.

- Enable Less secure app access
- Generate App Passwords

### Email Template
Create an HTML email template in src/main/resources/templates/email-template.html

### Run the Application
Use Maven to build and run the application:
```bash
mvn spring-boot:run
```
### Send an Email
Make a POST request to the /send-email endpoint with a JSON payload containing the recipient's email address and subject.

Example JSON payload:
```json
{
  "to": "recipient@example.com",
  "subject": "Welcome to Kavinda's Website!"
}
```
You can use tools like curl, Postman, or any HTTP client to send the request.

### Project Structure
- src/main/java: Contains the source code
  - com.example.email: Main package
  - EmailController.java: REST controller to handle email requests
  - EmailService.java: Service to send emails
  - Email.java: Model for email details
- src/main/resources: Contains configuration and template files
  - application.properties: Configuration properties for the application
  -templates/email-template.html: Default HTML email template
  - 
### Contributing
Contributions are welcome! Please open an issue or submit a pull request for any changes.
### License
This project is licensed under the MIT License.


This `README.md` file provides an overview of your Spring Boot email sender application, the configuration required, and how to run and use it. Make sure to replace `your-username` with your actual GitHub username and update any other placeholders with your specific details.

