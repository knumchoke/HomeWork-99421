# Job Application System

This project is a Java-based job application system that allows applicants to submit their information, qualifications, and position preferences. The system follows the Model-View-Controller (MVC) architecture pattern.

## Project Structure

### Root Files
- `Driver.java`: The main entry point of the application. It initializes the Swing GUI by creating and displaying the main window.
- `View.java`: A factory class that creates the main window of the application.
- `UIConstants.java`: Contains all UI-related constants including window dimensions, fonts, and layout settings. This ensures consistent styling across the application.

### Model Package (`src/homework/model/`)
Contains the data models of the application:
- `Applicant.java`: Represents an applicant with their personal information, qualifications, and position preferences.
- `Qualification.java`: Represents a qualification with its type, description.
- `Position.java`: Represents a job position with its title and department.

### View Package (`src/homework/view/`)
Contains all the UI components:

#### Main Components
- `MainWindow.java`: The main application window that contains all other UI components.
- `HeaderPanel.java`: Displays the application header with title and description.

#### Form and Display Components
The application uses three main panel components that work together to handle the application process:

1. **ApplicationFormPanel.java**
   - The main form panel where users input their information
   - Contains input fields for:
     - Personal details (ID, name, address, province)
     - Gender selection (radio buttons for male/female)
     - Education and major
     - Qualifications (up to 5 selections)
     - Desired positions (up to 3 selections)
   - Uses `GridBagLayout` for organized form layout
   - Has a submit button ("ตกลง")
   - Converts form data into an `Applicant` object using `toApplicant()` method

2. **ApplicantInfoPanel.java**
   - Displays the submitted information in a readable format
   - Takes an `Applicant` object and displays:
     - Personal information (ID, name, address, etc.)
     - Qualifications list
     - Desired positions list
   - Uses `BoxLayout` for vertical arrangement
   - Formats text with HTML for better display
   - Each piece of information is displayed as a label

3. **ApplicantDetailPanel.java**
   - Container panel that combines information display with edit functionality
   - Contains:
     - A title "รายละเอียดของผู้สมัคร"
     - An `ApplicantInfoPanel` to show the information
     - An edit button ("แก้ไข")
   - When edit button is clicked, it calls the provided `onEdit` callback
   - Uses `BoxLayout` for vertical arrangement
   - Adds proper spacing and borders

#### Component Interaction Flow
```
ApplicationFormPanel (Input)
        ↓
    Applicant Object
        ↓
ApplicantDetailPanel (Container)
        ↓
ApplicantInfoPanel (Display)
```

### Controller Package (`src/homework/controller/`)
- `Controller.java`: Handles the business logic and coordinates between the model and view components. It processes form submissions and manages the application state.

## Technical Details

### UI Constants
The application uses consistent UI elements defined in `UIConstants.java`:
- Window size: 570x720 pixels
- Font hierarchy: Heading (18pt), Subheading (16pt), Body (14pt), and Normal (14pt)
- Maximum limits: 5 qualifications and 3 positions per application
- Grid layout settings for consistent spacing

### Architecture
The application follows the MVC pattern:
- Model: Data classes in the model package
- View: UI components in the view package
- Controller: Business logic in the controller package

This separation of concerns makes the code more maintainable and easier to test.

## Features
- Modern, user-friendly job application form
- Input fields for applicant's personal information, qualifications, and desired positions
- Data validation and error handling
- Detailed applicant summary view with edit option
- Modular, maintainable codebase using MVC principles

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