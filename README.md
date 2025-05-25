# STOU-TEC Job Application Form

A Java Swing application for submitting job applications to STOU-TEC Co., Ltd. This project demonstrates best practices in Java Swing UI design, MVC separation, and code organization.

## Features
- Modern, user-friendly job application form
- Input fields for applicant's personal information, qualifications, and desired positions
- Data validation and error handling
- Detailed applicant summary view with edit option
- Modular, maintainable codebase using MVC principles

## Project Structure
```
src/homework/
├── UIConstants.java                # UI-related constants
├── View.java                       # Main window factory
├── Driver.java                     # Application entry point
├── controller/
│   └── Controller.java             # Handles form logic and events
├── model/
│   ├── Applicant.java              # Applicant data model
│   ├── Position.java               # Position data model
│   └── Qualification.java          # Qualification data model
└── view/
    ├── MainWindow.java             # Main application window
    ├── HeaderPanel.java            # Header section
    ├── ApplicationFormPanel.java   # Application form UI
    ├── ApplicantDetailPanel.java   # Applicant detail summary UI
    └── ApplicantInfoPanel.java     # Applicant info display UI
```

## How to Run
1. **Requirements:**
   - Java 17 or later
   - Any IDE (Eclipse, IntelliJ, VS Code) or command line

2. **Build & Run:**
   - Compile all Java files in the `src/homework` directory.
   - Run the `homework.Driver` class.

   **Example (command line):**
   ```sh
   javac -d out src/homework/**/*.java
   java -cp out homework.Driver
   ```

3. **Usage:**
   - Fill out the application form.
   - Click "ตกลง" to view a summary of your application.
   - Click "แก้ไข" to return to the form and make changes.

## Customization
- You can edit the sample positions and qualifications in `model/Position.java` and `model/Qualification.java`.
- UI constants (fonts, sizes) can be changed in `UIConstants.java`.

## License
This project is for educational purposes. 