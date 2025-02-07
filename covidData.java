// 672115045 Virawit Kongthong ADT Tutorial 5

import java.util.Random;
import java.util.Vector;

public class covidData {
    public static void main(String[] args) {
        Random rand = new Random();
        LinkedListClass list = new LinkedListClass();
        Vector<String> prevVac1 = new Vector<String>();
        Vector<String> prevVac2 = new Vector<String>();
        prevVac1.add("Pzfier");
        prevVac1.add("First Dose: 2021-06-10");
        prevVac1.add("Second Dose: 2021-07-01");
        prevVac2.add("Pzfier");
        prevVac2.add("First Dose: 2021-06-10");
        prevVac2.add("Second Dose: N/A");

        CovidVaccine info1 = new CovidVaccine("100", "John", "Doe", prevVac1, "A12345", "Clinic A", "Provider X", "QR1Code", "Fully Vaccinated", "Cert-1001", "Stamp-1001");
        CovidVaccine info2 = new CovidVaccine("101", "Olivia", "Bennett", prevVac1, "B67890", "Health Center B", "Provider Y", "QR2Code", "Fully Vaccinated", "Cert-1002", "Stamp-1002");
        CovidVaccine info3 = new CovidVaccine("102", "Liam", "Carter", prevVac2, "C23456", "Vaccination Hub C", "Provider Z", "QR3Code", "Fully Vaccinated", "Cert-1003", "Stamp-1003");
        CovidVaccine info4 = new CovidVaccine("103", "Noah", "Harris", prevVac1, "D98765", "City Hospital D", "Provider X", "QR4Code", "Fully Vaccinated", "Cert-1004", "Stamp-1004");
        CovidVaccine info5 = new CovidVaccine("104", "Mason", "Clark", prevVac1, "E54321", "Private Practice E", "Provider Y", "QR5Code", "Fully Vaccinated", "Cert-1005", "Stamp-1005");
        CovidVaccine info6 = new CovidVaccine("105", "Sophia", "Turner", prevVac2, "A12345", "Clinic A", "Provider Z", "QR6Code", "Fully Vaccinated", "Cert-1006", "Stamp-1006");
        CovidVaccine info7 = new CovidVaccine("106", "James", "Mitchell", prevVac2, "B67890", "Health Center B", "Provider X", "QR7Code", "Fully Vaccinated", "Cert-1007", "Stamp-1007");
        CovidVaccine info8 = new CovidVaccine("107", "Ava", "Penton", prevVac1, "C23456", "Vaccination Hub C", "Provider Z", "QR8Code", "Fully Vaccinated", "Cert-1008", "Stamp-1008");
        CovidVaccine info9 = new CovidVaccine("108", "Harry", "Styles", prevVac2, "D98765", "City Hospital D", "Provider Y", "QR9Code", "Fully Vaccinated", "Cert-1009", "Stamp-1009");
        CovidVaccine info10 = new CovidVaccine("109", "Guy", "Kongthong", prevVac1, "E54321", "Private Practice E", "Provider X", "QR10Code", "Fully Vaccinated", "Cert-1010", "Stamp-1010");


        list.insert(info1);
        list.insert(info2);
        list.insert(info3);
        list.insert(info4);
        list.insert(info5);
        list.insert(info6);
        list.insert(info7);
        list.insert(info8);
        list.insert(info9);
        list.insert(info10);

        System.out.println();

        int firstPick = rand.nextInt(10);
        int secondPick;
        do {
            secondPick = rand.nextInt(10);
        } while (secondPick == firstPick);

        int pick = firstPick;
        for (int i = 0; i < 2; i++) {
            switch (pick) {
                case 0:
                    list.delete(info1);
                    break;
                case 1:
                    list.delete(info2);
                    break;
                case 2:
                    list.delete(info3);
                    break;
                case 3:
                    list.delete(info4);
                    break;
                case 4:
                    list.delete(info5);
                    break;
                case 5:
                    list.delete(info6);
                    break;
                case 6:
                    list.delete(info7);
                    break;
                case 7:
                    list.delete(info8);
                    break;
                case 8:
                    list.delete(info9);
                    break;
                case 9:
                    list.delete(info10);
                    break;
                default:
                    break;
            }
            pick = secondPick;
        }
        System.out.println();

        list.printList();

        list.deleteAll();
        list.printList();

    }
}

class Node {
    CovidVaccine data;
    Node next;

    public Node(CovidVaccine data) {
        this.data = data;
        this.next = null;
    }
}

class CovidVaccine {
    private String id;
    private String fN;
    private String lN;
    private Vector<String> prevVacc;
    private String batchNum;
    private String vaccSite;
    private String healthProvider;
    private String qr;
    private String vaccStatus;
    private String certificateID;
    private String signatureStamp;

    public CovidVaccine(String idf, String firstName, String lastName, Vector<String> prevVaccF, String batchNumF, String vaccSiteF, String healthProviderF, String qrF, String vaccStatusF, String certificateIDF, String signatureStampF) {
        id = idf;
        fN = firstName;
        lN = lastName;
        prevVacc = prevVaccF;
        batchNum = batchNumF;
        vaccSite = vaccSiteF;
        healthProvider = healthProviderF;
        qr = qrF;
        vaccStatus = vaccStatusF;
        certificateID = certificateIDF;
        signatureStamp = signatureStampF;
    }

    public int getNumOfVaccines() {
        return prevVacc.size();
    }

    @Override
    public String toString() {
        return "SID " + id + ", First Name " + fN + ", Last Name " + lN + ", Previous Vaccines " + prevVacc + ", Batch Number " + batchNum + ", Vaccination Site " + vaccSite + ", Health Provider " + healthProvider + ", QR Code " + qr + ", Vaccination Status " + vaccStatus + ", CertificateID " + certificateID + ", Signature Stamp " + signatureStamp;
    }

}

class LinkedListClass {
    private Node head;

    public LinkedListClass() {
        head = null;
    }

    public void insert(CovidVaccine info) {
        Node newNode = new Node(info);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            System.out.println("Inserted " + info.toString());
            System.out.println();
        }

    }

    public void delete(CovidVaccine info) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        if (head.data == info) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != info) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Deleted " + info.toString());
            System.out.println();


        } else {
            System.out.println("Data not found in the list!");
        }
    }

    public void deleteAll() {
        head = null;
    }

    public int getSize() {
        int count = 1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " -> ");
            current = current.next;
        }

        if (head == null) {
            System.out.println("List is empty");
        }
    }
}