package id.ac.umn.sistemabsensielektronik;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDataKaryawan extends RecyclerView.Adapter<AdapterDataKaryawan.ViewHolder>{

    private ArrayList<DataKaryawan> dataKaryawan;
    private Context context;

    public AdapterDataKaryawan(ArrayList<DataKaryawan> karyawans, Context ctx){
        //Inisiasi data dan variabel yang akan digunakan:
        dataKaryawan = karyawans;
        context = ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        //Inisiasi View:
        TextView viewFirstName, viewLastName, viewEmail, viewDivision, viewNIK;

        ViewHolder(View v){
            super(v);
            viewFirstName = (TextView) v.findViewById(R.id.viewFirstName);
            viewLastName = (TextView) v.findViewById(R.id.viewLastName);
            viewEmail = (TextView) v.findViewById(R.id.viewEmail);
            viewDivision = (TextView) v.findViewById(R.id.viewDivision);
            viewNIK = (TextView) v.findViewById(R.id.viewNIK);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        //Inisiasi ViewHolder:
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_karyawan, parent, false);
        //Setting ukuran view, margin padding, dan parameter layout lainnya:
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        //Menampilkan data pada View:
        final String viewFirstName = dataKaryawan.get(position).getFirstName();
        holder.viewFirstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //NIH DIISI YE...
            }
        });
        holder.viewFirstName.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                //NIH DIISI JUGA BENTAR...
                return true;
            }
        });
        holder.viewFirstName.setText(viewFirstName);
    }

    public int getItemCount(){
        //Mengembalikan jumlah data:
        return dataKaryawan.size();
    }
}
