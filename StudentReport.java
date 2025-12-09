import java.util.Scanner;

public class StudentReport {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ================= SCHOOL DETAILS =================
        System.out.print("Enter School Name: ");
        String school = input.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacher = input.nextLine();

        System.out.print("Enter Grade: ");
        String grade = input.nextLine();

        System.out.print("Enter Year: ");
        int year = input.nextInt();

        int STUDENTS = 12;

        // ================= ARRAYS =================
        String[] names = new String[STUDENTS];
        double[] english = new double[STUDENTS];
        double[] math = new double[STUDENTS];
        double[] history = new double[STUDENTS];
        double[] geography = new double[STUDENTS];
        double[] science = new double[STUDENTS];
        double[] programming = new double[STUDENTS];
        double[] totals = new double[STUDENTS];
        char[] ranks = new char[STUDENTS];

        // ================= INPUT STUDENTS =================
        for (int i = 0; i < STUDENTS; i++) {
            input.nextLine(); // clear input

            System.out.println("\nEnter Student " + (i + 1) + " Name:");
            names[i] = input.nextLine();

            System.out.print("English: ");
            english[i] = input.nextDouble();

            System.out.print("Math: ");
            math[i] = input.nextDouble();

            System.out.print("History: ");
            history[i] = input.nextDouble();

            System.out.print("Geography: ");
            geography[i] = input.nextDouble();

            System.out.print("Science: ");
            science[i] = input.nextDouble();

            System.out.print("Programming: ");
            programming[i] = input.nextDouble();

            // TOTAL
            totals[i] = english[i] + math[i] + history[i]
                    + geography[i] + science[i] + programming[i];

            // GRADE
            if (totals[i] >= 540)
                ranks[i] = 'A';
            else if (totals[i] >= 480)
                ranks[i] = 'B';
            else if (totals[i] >= 420)
                ranks[i] = 'C';
            else if (totals[i] >= 360)
                ranks[i] = 'D';
            else
                ranks[i] = 'F';
        }

        // ================= CLASS TOTALS =================
        double totalEng = 0, totalMath = 0, totalHist = 0;
        double totalGeo = 0, totalSci = 0, totalProg = 0;

        int A = 0, B = 0, C = 0, D = 0, F = 0;

        for (int i = 0; i < STUDENTS; i++) {
            totalEng += english[i];
            totalMath += math[i];
            totalHist += history[i];
            totalGeo += geography[i];
            totalSci += science[i];
            totalProg += programming[i];

            if (ranks[i] == 'A') A++;
            else if (ranks[i] == 'B') B++;
            else if (ranks[i] == 'C') C++;
            else if (ranks[i] == 'D') D++;
            else if (ranks[i] == 'F') F++;
        }

        // ================= OUTPUT REPORT =================
        System.out.println("\n==========================================================================================");
        System.out.println("School Name: " + school);
        System.out.println("\tTeacher: " + teacher);
        System.out.println("\t\tGrade: " + grade);
        System.out.println("\t\t\tYear: " + year);
        System.out.println("============================================================================================");

        System.out.printf("%-15s %8s %8s %8s %10s %9s %12s %8s %6s\n",
                "Student", "Eng", "Math", "Hist", "Geo", "Sci", "Prog", "Total", "Rank");

        System.out.println("--------------------------------------------------------------------------------------------");

        for (int i = 0; i < STUDENTS; i++) {
            System.out.printf("%-15s %8.2f %8.2f %8.2f %10.2f %9.2f %12.2f %8.2f %6c\n",
                    names[i], english[i], math[i], history[i],
                    geography[i], science[i], programming[i],
                    totals[i], ranks[i]);
        }

        System.out.println("--------------------------------------------------------------------------------------------");

        System.out.printf("%-15s %8.2f %8.2f %8.2f %10.2f %9.2f %12.2f\n",
                "TOTALS",totalEng, totalMath, totalHist, totalGeo, totalSci, totalProg);

        System.out.printf("%-15s %8.2f %8.2f %8.2f %10.2f %9.2f %12.2f\n",
                "AVERAGE",
                totalEng / STUDENTS,
                totalMath / STUDENTS,
                totalHist / STUDENTS,
                totalGeo / STUDENTS,
                totalSci / STUDENTS,
                totalProg / STUDENTS);

        System.out.println("============================================================================================");
        System.out.println("Ranks Summary:");
        System.out.println("\t\t\t\tA's: " + A + "   B's: " + B + "   C's: " + C + "   D's: " + D + "   F's: " + F);
        System.out.println("============================================================================================");

        input.close();
    }
}