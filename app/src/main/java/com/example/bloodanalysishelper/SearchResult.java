package com.example.bloodanalysishelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResult extends AppCompatActivity {

    ListView listView;
    Intent go;
    ArrayList<Analysis> All_Analysis;
    int Analysis_num;
    TextView searchTX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);
        listView =findViewById(R.id.lv);
        searchTX = findViewById(R.id.searchTX);
        All_Analysis = new ArrayList<>();
        Analysis_num=30;
        ToArrayList(All_Analysis);
        if (getIntent().hasExtra("SearchKeyWord")){
            search();
        }else if (getIntent().hasExtra("ViewAll")){
            searchTX.setText(" All Analysis..");
            searchAdapor searchAdapor = new searchAdapor(this,All_Analysis);
            listView.setAdapter(searchAdapor);
        }

    }

    private void search() {
        ArrayList<Analysis> SearchResult = new ArrayList<>();
        int x = 0;
        String  SearchKeyWord = getIntent().getExtras().getString("SearchKeyWord");
        searchTX.setText(" search result for "+SearchKeyWord);
        for (int i =0;i<Analysis_num-1;i++) {
            if (All_Analysis.get(i).getName().toUpperCase().contains(SearchKeyWord.toUpperCase())) {
                Analysis analysis = new Analysis();
                analysis.setName(All_Analysis.get(i).getName());
                analysis.setImage(All_Analysis.get(i).getImage());
                SearchResult.add(analysis);
                x=1;
            }
        }
        if(x==0){
            Toast.makeText(this, "Sorry ..No Search Result for: "+SearchKeyWord, Toast.LENGTH_LONG).show();
        }
        searchAdapor searchAdapor = new searchAdapor(this,SearchResult);
        listView.setAdapter(searchAdapor);
    }


     public void ToArrayList(ArrayList<Analysis> x){
     /*   Analysis analysis = new Analysis();
        analysis.setName("a");
        analysis.setImage(R.drawable.a);
        x.add(analysis);

         Analysis analysis1 = new Analysis();
         analysis1.setName("b");
         analysis1.setImage(R.drawable.b);
         x.add(analysis1);

         Analysis analysis2 = new Analysis();
         analysis2.setName("c");
         analysis2.setImage(R.drawable.c);
         x.add(analysis2);

         Analysis analysis3 = new Analysis();
         analysis3.setName("d");
         analysis3.setImage(R.drawable.d);
         x.add(analysis3);

         Analysis analysis4= new Analysis();
         analysis4.setName("e");
         analysis4.setImage(R.drawable.e);
         x.add(analysis4);*/

         Analysis analysis65= new Analysis();
         analysis65.setName("CSF");
         analysis65.setImage(R.drawable.a65);
         x.add(analysis65);


         Analysis analysis66= new Analysis();
         analysis66.setName("loctate-CSF");
         analysis66.setImage(R.drawable.a66);
         x.add(analysis66);

         Analysis analysis68= new Analysis();
         analysis68.setName("phosphate - ALT");
         analysis68.setImage(R.drawable.a68);
         x.add(analysis68);

         Analysis analysis69= new Analysis();
         analysis69.setName("Alkaline - Ammonio -ANA");
         analysis69.setImage(R.drawable.a69);
         x.add(analysis69);

         Analysis analysis70= new Analysis();
         analysis70.setName("ASOT - AST");
         analysis70.setImage(R.drawable.a70);
         x.add(analysis70);

         Analysis analysis71= new Analysis();
         analysis71.setName("Blood Goses - ABG ");
         analysis71.setImage(R.drawable.a71);
         x.add(analysis71);

         Analysis analysis72= new Analysis();
         analysis72.setName("Calcium");
         analysis72.setImage(R.drawable.a72);
         x.add(analysis72);

         Analysis analysis73= new Analysis();
         analysis73.setName("ESR");
         analysis73.setImage(R.drawable.a73);
         x.add(analysis73);

         Analysis analysis74= new Analysis();
         analysis74.setName("Blood Glucose");
         analysis74.setImage(R.drawable.a74);
         x.add(analysis74);

         Analysis analysis75= new Analysis();
         analysis75.setName("HBF-HBAK");
         analysis75.setImage(R.drawable.a75);
         x.add(analysis75);

         Analysis analysis76= new Analysis();
         analysis76.setName("Colesterol");
         analysis76.setImage(R.drawable.a76);
         x.add(analysis76);

         Analysis analysis77= new Analysis();
         analysis77.setName("LDL - HDL ");
         analysis77.setImage(R.drawable.a77);
         x.add(analysis77);

         Analysis analysis78= new Analysis();
         analysis78.setName("Albumin - Potassium");
         analysis78.setImage(R.drawable.a78);
         x.add(analysis78);

         Analysis analysis79= new Analysis();
         analysis79.setName("RF - NA -TIBC -TG");
         analysis79.setImage(R.drawable.a79);
         x.add(analysis79);

         Analysis analysis80= new Analysis();
         analysis80.setName("Uric acid -Vitamin A - Tropanin");
         analysis80.setImage(R.drawable.a80);
         x.add(analysis80);

         Analysis analysis82= new Analysis();
         analysis82.setName("NewBorn Clinical Chemistry");
         analysis82.setImage(R.drawable.a82);
         x.add(analysis82);

         Analysis analysis83= new Analysis();
         analysis83.setName("bun");
         analysis83.setImage(R.drawable.a83);
         x.add(analysis83);

         Analysis analysis84= new Analysis();
         analysis84.setName("CBC");
         analysis84.setImage(R.drawable.a84);
         x.add(analysis84);

         Analysis analysis85= new Analysis();
         analysis85.setName("CBC - WBC");
         analysis85.setImage(R.drawable.a85);
         x.add(analysis85);

         Analysis analysis86= new Analysis();
         analysis86.setName("PT-APTT");
         analysis86.setImage(R.drawable.a86);
         x.add(analysis86);

         Analysis analysis87= new Analysis();
         analysis87.setName("Plosminogen");
         analysis87.setImage(R.drawable.a87);
         x.add(analysis87);

         Analysis analysis88= new Analysis();
         analysis88.setName("Protein C - Protein S -AT III");
         analysis88.setImage(R.drawable.a88);
         x.add(analysis88);

         Analysis analysis89= new Analysis();
         analysis89.setName("Poctus - OPTT - PTT");
         analysis89.setImage(R.drawable.a89);
         x.add(analysis89);

         Analysis analysis90= new Analysis();
         analysis90.setName("Protein C - Protein S -AT III (Cont..)");
         analysis90.setImage(R.drawable.a90);
         x.add(analysis90);

         Analysis analysis91= new Analysis();
         analysis91.setName("PT-OPTT-INR-Bleeding Time");
         analysis91.setImage(R.drawable.a91);
         x.add(analysis91);

         Analysis analysis92= new Analysis();
         analysis92.setName("Protein C - Protein S - AT III");
         analysis92.setImage(R.drawable.a92);
         x.add(analysis92);

         Analysis analysis97= new Analysis();
         analysis97.setName("Thyroid Function Test (Cont..)");
         analysis97.setImage(R.drawable.a97);
         x.add(analysis97);

         Analysis analysis98= new Analysis();
         analysis98.setName("Thyroid Function Test (Cont..)");
         analysis98.setImage(R.drawable.a98);
         x.add(analysis98);

         Analysis analysis99= new Analysis();
         analysis99.setName("Cortisol");
         analysis99.setImage(R.drawable.a99);
         x.add(analysis99);




     }


}
