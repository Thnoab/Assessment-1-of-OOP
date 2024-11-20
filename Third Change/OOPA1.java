package aaa;

import java.util.ArrayList;

// Base class for health professionals, representing all types of doctors or health-related professionals
// I used this base class to encapsulate common attributes and behaviors, providing a foundation for subclasses.
class HealthProfessional {
    private final int id;  // Unique identifier for each health professional
    private final String name;  // Name of the health professional
    private final String specialization;  // Specialization of the health professional

    // Default constructor to create a default health professional object
    // I provided default values as placeholders to facilitate the creation of uninitialized objects.
    public HealthProfessional() {
        this.id = 0;  // Default ID
        this.name = "Unknown";  // Default name
        this.specialization = "Unknown";  // Default specialization
    }

    // Parameterized constructor to create a specific health professional object
    // I used this constructor to allow passing specific information directly, ensuring object initialization completeness.
    public HealthProfessional(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // Print detailed information about the health professional
    // I designed this method to standardize the output of basic health professional information.
    public void printDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialization: " + specialization);
    }

    // Print the type of the health professional
    // This is a virtual method that allows subclasses to override it, demonstrating polymorphism.
    public void printProfessionalType() {
        System.out.println("Health Professional");
    }
}

// GeneralPractitioner class is a subclass of HealthProfessional, representing general practitioners
// I used this subclass to add attributes specific to general practitioners, such as gpType, to distinguish its uniqueness.
class GeneralPractitioner extends HealthProfessional {
    private final String gpType;  // Indicates the type of general practitioner, such as "Primary Care Physician"

    // Default constructor to create a default general practitioner object
    // Provides a default type "General" for quickly creating general objects.
    public GeneralPractitioner() {
        super();  // Call the default constructor of the parent class
        this.gpType = "General";  // Default type
    }

    // Parameterized constructor to create a specific general practitioner object
    // Through this constructor, both parent class general attributes and subclass-specific attributes can be initialized simultaneously.
    public GeneralPractitioner(int id, String name, String specialization, String gpType) {
        super(id, name, specialization);  // Call the constructor of the parent class
        this.gpType = gpType;
    }

    @Override
    public void printDetails() {
        super.printDetails();  // Call the print method of the parent class
        // I extended the parent class method to include gpType information, reflecting the uniqueness of the subclass.
        System.out.println("Type: " + gpType);
    }

    @Override
    public void printProfessionalType() {
        // I overrode the parent class method to output the type as "General Practitioner."
        System.out.println("General Practitioner");
    }
}

// Specialist class is a subclass of HealthProfessional, representing specialists
// I added the specific field specialty as a new attribute to facilitate extending different specialist types in the subclass.
class Specialist extends HealthProfessional {
    private final String specialty;  // Indicates the specific field of the specialist, such as "Cardiology"

    // Default constructor to create a default specialist object
    // Default value "Unknown Specialty" provides the ability to quickly create placeholder objects.
    public Specialist() {
        super();  // Call the default constructor of the parent class
        this.specialty = "Unknown Specialty";  // Default field
    }

    // Parameterized constructor to create a specific specialist object
    // This constructor passes all necessary information to ensure the completeness of object initialization.
    public Specialist(int id, String name, String specialization, String specialty) {
        super(id, name, specialization);  // Call the constructor of the parent class
        this.specialty = specialty;
    }

    @Override
    public void printDetails() {
        super.printDetails();  // Call the print method of the parent class
        // I extended the printing functionality to output the specialty field, clearly indicating the specialist's field.
        System.out.println("Specialty: " + specialty);
    }

    @Override
    public void printProfessionalType() {
        // I overrode the parent class method to output the type as "Specialist."
        System.out.println("Specialist");
    }
}

// Appointment class represents patient appointment information
// I designed this class to encapsulate appointment details between patients and health professionals.
class Appointment {
    private String patientName;  // Patient's name
    private final String mobile;  // Patient's mobile number, used as a unique identifier
    private final String timeSlot;  // Appointment time slot
    private final HealthProfessional healthProfessional;  // Associated health professional

    // Constructor to create an appointment object
    // This constructor ensures all necessary appointment information is provided at the time of object creation.
    public Appointment(String patientName, String mobile, String timeSlot, HealthProfessional healthProfessional) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.timeSlot = timeSlot;
        this.healthProfessional = healthProfessional;
    }

    // Print detailed information about the appointment
    // I designed the printDetails method to output complete appointment information, including doctor details.
    public void printDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Mobile: " + mobile);
        System.out.println("Time Slot: " + timeSlot);
        healthProfessional.printDetails();  // Call the print method of the doctor
        System.out.println("------------------------------");
    }

    // Get the patient's mobile number (used for searching or canceling appointments)
    // This method provides read-only access to the patient's mobile number, adhering to encapsulation principles.
    public String getMobile() {
        return mobile;
    }

    // Get the patient's name
    // Provides read-only access to the patient's name.
    public String getPatientName() {
        return patientName;
    }

    // Modify the patient's name
    // I provided the setPatientName method to allow dynamic updates to the patient's name in the appointment.
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}

// AppointmentManager class manages all appointments
// This class manages all appointments using an ArrayList and provides functionality to add, print, and cancel appointments.
class AppointmentManager {
    private final ArrayList<Appointment> appointments;  // Collection storing all appointments
    // I chose ArrayList to store appointments because it allows dynamic resizing and supports efficient addition and iteration.

    // Constructor to initialize the appointment list
    // The constructor initializes an empty ArrayList to ensure subsequent operations can be executed without issues.
    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    // Add an appointment to the list
    // I designed the addAppointment method to add new appointments to the list and print a confirmation message to ensure users can see the result.
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);  // Add the appointment to the collection
        // Access the patient's name using the getPatientName method to adhere to encapsulation principles.
        System.out.println("Appointment added for " + appointment.getPatientName());
    }

    // Print all appointment information
    // The printExistingAppointments method iterates through the current appointment list and calls the printDetails method of each appointment object to print details.
    public void printExistingAppointments() {
        if (appointments.isEmpty()) {
            // Prompt the user when the list is empty to indicate no appointments exist.
            System.out.println("No existing appointments.");
            return;
        }
        for (Appointment appointment : appointments) {
            // Iterate through the list and print the details of each appointment.
            appointment.printDetails();
        }
    }

    // Cancel an appointment by mobile number
    // The cancelAppointment method searches for and removes the corresponding appointment by matching the mobile number.
    public void cancelAppointment(String mobile) {
        boolean found = false;  // Flag variable indicating whether a matching appointment was found
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getMobile().equals(mobile)) {
                // When the mobile number matches, remove the corresponding appointment and print a prompt.
                appointments.remove(i);
                System.out.println("Appointment canceled for mobile: " + mobile);
                found = true;  // Update the flag variable to indicate the appointment was found
                break;
            }
        }
        if (!found) {
            // Prompt the user if no matching appointment is found.
            System.out.println("No appointment found for mobile: " + mobile);
        }
    }
}

// Main class OOPA1, used to test functionality
// The main method of the OOPA1 class is used to test the functionality of the aforementioned classes, including object creation, adding appointments, printing appointments, and canceling appointments.
public class OOPA1 {
    public static void main(String[] args) {
        // Create health professional objects
        // I tested inheritance and polymorphism by creating multiple health professional objects of different types.
        HealthProfessional gp1 = new GeneralPractitioner(1, "Dr. Alexios", "General Medicine", "Primary Care");
        HealthProfessional gp2 = new GeneralPractitioner(2, "Dr. Anna", "Family Medicine", "Primary Care");
        HealthProfessional gp3 = new GeneralPractitioner(3, "Dr. Arbiter", "Pediatrics", "Primary Care");
        HealthProfessional sp1 = new Specialist(4, "Dr. Clermont", "Cardiology", "Cardiologist");
        HealthProfessional sp2 = new Specialist(5, "Dr. Abdulmejid", "Dermatology", "Dermatologist");

        // Print health professional information
        // Calls the printProfessionalType and printDetails methods to print information about each health professional.
        System.out.println("Health Professionals:");
        gp1.printProfessionalType();
        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printProfessionalType();
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printProfessionalType();
        gp3.printDetails();
        System.out.println("------------------------------");
        sp1.printProfessionalType();
        sp1.printDetails();
        System.out.println("------------------------------");
        sp2.printProfessionalType();
        sp2.printDetails();

        // Create an instance of AppointmentManager
        // Instantiate AppointmentManager to manage appointments and test its methods.
        AppointmentManager manager = new AppointmentManager();

        // Add appointments to the system
        // Add multiple appointment objects to test the correctness of the addAppointment method.
        manager.addAppointment(new Appointment("Tadokoro Koji", "1145141919", "10:00", gp1));
        manager.addAppointment(new Appointment("Franz", "0987654321", "14:00", sp1));
        manager.addAppointment(new Appointment("Yasukawa", "1122334455", "09:00", gp2));
        manager.addAppointment(new Appointment("Tehmasab", "5566778899", "11:30", sp2));

        // Print existing appointments
        // Call the printExistingAppointments method to print all current appointment records.
        System.out.println("\nExisting appointments:");
        manager.printExistingAppointments();

        // Cancel an appointment by mobile number
        // Cancel an appointment using the mobile number "1145141919" to test if the cancelAppointment method executes correctly.
        manager.cancelAppointment("1145141919");

        // Print updated appointments
        // Call the printExistingAppointments method again to confirm if the appointment records have been updated.
        System.out.println("\nUpdated appointments:");
        manager.printExistingAppointments();
    }
}




