package collections;

import java.util.ArrayList;
import java.util.List;

public class ColEx10 {
    public static void main(String[] args) {

        List<String> companies = new ArrayList<>();
        companies.add("DELL");
        companies.add("APPLE");
        companies.add("SAMSUNG");
        companies.add("SONY");
        companies.add("ALCATEL");

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < companies.size() ; i++) {
            builder.append(companies.get(i));

            if (companies.size()-1 > i){
                builder.append(", ");
            }
        }
        System.out.println(builder.toString());
    }
}

