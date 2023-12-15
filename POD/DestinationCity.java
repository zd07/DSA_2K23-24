package POD;

import java.util.List;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        for(int i=0;i<paths.size();++i){
            int flag=0;

            // getting destination from each path
            String destination=paths.get(i).get(1);

            // running loop for comparing each path's source with current distination
            for(int j=0;j<paths.size();j++){

                //get source of path j
                String source=paths.get(j).get(0);

                //comparing destinaton with source 
                // if this is equal that means current destination is source of any other path
                if(destination.equals(source)){
                    flag=1;
                    break;
                }
            }

            //if flag is equqal to 0 that means current destination is not source for any path so return the destination
            if(flag==0) return destination;
        }
        
        return "";
    }
}
