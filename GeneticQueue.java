import java.util.*;
import javafx.scene.control.*;
import javafx.collections.*;
public class GeneticQueue extends LinkedList<String> implements Queue<String>
{
    public void add_input()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add a Chemical Base");
        dialog.setHeaderText("Enter Chemical Base");
        dialog.setContentText("Please enter A, T, C, or G: ");
        Optional<String> opt = dialog.showAndWait();
        String base = opt.get();
        addBase(base);
    }
    
    public void addBase(String base)
    {
        String added = null;
        if (base.equals("T") || base.equals("C") || base.equals("G"))
        {
            added = base;
        }
        else
        {
            added = "A";
        }
        offer(added);
    }
    
    public void removeBase()
    {
        poll();
    }
    
    public void mutate()
    {
        int num_bases = 0;
        while (!isEmpty())
        {
            poll(); num_bases++;
        }
        for (int i = 0; i < num_bases; i++)
        {
            String[] bases = {"A","T","C","G"};
            Random rand = new Random();
            int ind = rand.nextInt(bases.length);
            String base = bases[ind];
            offer(base);
        }
    }
    
    public String toString()
    {
        if (isEmpty())
        {
            return "Empty";
        }
        Iterator<String> iter = iterator();
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext())
        {
            String next = iter.next();
            sb.append(next);
        }
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
        GeneticQueue gene = new GeneticQueue();
        gene.addBase("A");
        gene.addBase("G");
        gene.addBase("C");
        gene.addBase("B");
        System.out.println(gene);
        gene.removeBase();
        gene.addBase("T");
        gene.addBase("Z");
        System.out.println(gene);
        gene.mutate();
        System.out.println(gene);
    }
}
