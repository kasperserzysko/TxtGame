package Areas;


import org.jetbrains.annotations.NotNull;


import java.util.Arrays;
import java.util.HashMap;

public class Area {
    private final String name;
    private final HashMap<Integer, String> surrounding_areas = new HashMap<>();


    public Area(String name, String @NotNull ... areas) {
        this.name = name;

        if(areas.length>0){
            for (int i = 0; i < areas.length; i++){
                this.surrounding_areas.put(i, Arrays.asList(areas).get(i));
            }
        }
    }

    public HashMap<Integer, String> getSurrounding_areas(){
        return this.surrounding_areas;
    }





}
