
/**
 * Write a description of class HelpGroups here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.List;
public class HelpGroups
{
    List<Help> helpers;
    
    public HelpGroups()
    {
        this.helpers = new ArrayList<Help>();
    }
    
    public void add(Help help)
    {
        helpers.add(help);
    }
    
    public Help find(String query)
    {
        for (Help h : helpers)
        {
            String name = h.getName();
            
            if(name.equals(query))
            {
                return h;
            }
        }
        
        return null;
    }
}
