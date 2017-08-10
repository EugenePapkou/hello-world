import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;


public class HelloWorld
{   
    public static void main(String[] args)
    {         
        ArrayList<Person> people = new ArrayList<>();
        try
        {
	    // creating DOM-analyzer
            DocumentBuilderFactory abc = DocumentBuilderFactory.newInstance();
            DocumentBuilder q = abc.newDocumentBuilder();
            BufferedReader d = 
                    new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter name of file .xml");
            Document doc_xml = q.parse(d.readLine());
           
            // return a list with  child elements which have a specific name
            NodeList nodeLst = doc_xml.getElementsByTagName("Person");
            
            for(int je = 0; je < nodeLst.getLength(); je++)
            {
                people.add(new Person());
                Node fstNode=nodeLst.item(je); // reading the first element of 'Person'
                if(fstNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element elj = (Element)fstNode;
                    people.get(je).age 
                            = Integer.parseInt(elj.getAttribute("age"));                    
                    
                    NodeList nljx = elj.getElementsByTagName("firstName");
                    Element eljx = (Element)nljx.item(0);
                    NodeList nljxc = eljx.getChildNodes(); 
                    people.get(je).first_name 
                            = ((Node)nljxc.item(0)).getNodeValue();
                    
                    NodeList n = elj.getElementsByTagName("lastName");
                    Element el=(Element)n.item(0);
                    NodeList nl = el.getChildNodes();                    
                    people.get(je).last_name 
                            = ((Node)nl.item(0)).getNodeValue();
                    // printing on console the contents of document
                    /* System.out.println(" "+people.get(je).age+" "
                            + ""+people.get(je).first_name+" "
                            + ""+people.get(je).last_name+""); */
                }
            }
        }
        catch(Exception e){}
        
        int x = 0;
        int j;
  
        for (j = 0; j <= people.size() - 1; j++) // Average age
        {
            x += people.get(j).age;            
        }
        double average_age = (double)x / (double)j;
        System.out.println("Average age is " + average_age);                
        
        x = people.get(0).age; // the youngest person
        int id = 0;
        for (j = 1; j <= people.size() - 1 ; j++) 
        {
            if (x > people.get(j).age)
            {           
                x = people.get(j).age;            
                id = j;
                if (j == people.size() - 1)
                {
                    break;
                }
            }            
        }
        
        if (x == people.get(0).age)
        {
            System.out.println("The youngest person is " + 
                    people.get(0).first_name
                        + " " + people.get(0).last_name);
        }
        else            
        {
                System.out.println("The youngest person is " +
                    people.get(id).first_name
                        + " " + people.get(id).last_name);                
        }
        
        x = people.get(0).age; // the oldest person
        for (j = 1; j <= people.size() - 1 ; j++) 
        {
            if (x < people.get(j).age)
            {           
                x = people.get(j).age;            
                id = j;
                if (j == people.size() - 1)
                {
                    break;
                }
            }            
        }    
        
        if (x == people.get(0).age)
        {
            System.out.println("The oldest person is "
                    + people.get(0).first_name
                        + " " + people.get(0).last_name);        
        }
        else
        {
            System.out.println("The oldest person is "
                    + people.get(id).first_name
                        + " " + people.get(id).last_name);             
        }
    }
}

class Person
{
    String first_name;
    String last_name;
    int age;
}
