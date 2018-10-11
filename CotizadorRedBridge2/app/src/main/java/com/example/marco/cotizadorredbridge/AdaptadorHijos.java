package com.example.marco.cotizadorredbridge;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorHijos extends RecyclerView.Adapter<AdaptadorHijos.ViewHolderHijos> {

    private EditText etedad;
    private RecyclerView mRecyclerView;
    private Context mContext;
    public static ArrayList<EditModel> editModelArrayList;

    ArrayList<HijoVo> listaHijos;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          /*  int itemPosition = mRecyclerView.getChildLayoutPosition(v);
            String item = String.valueOf(listaHijos.get(itemPosition));
            Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();*/
        }
    };

    public AdaptadorHijos(ArrayList<HijoVo> listaHijos, Context context) {

        this.listaHijos = listaHijos;
        this.mContext = context;
    }



    @NonNull
    @Override
    public ViewHolderHijos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_txtview,null,false);
        view.setOnClickListener(mOnClickListener);
        return new ViewHolderHijos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderHijos holder, final int position) {

        //etedad = holder.añoset.findViewById(R.id.editText3);
        holder.añoset.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                   if(holder.añoset.getText().toString().trim().length()>0)
                       listaHijos.get(position).setAños(Integer.parseInt(String.valueOf(holder.añoset.getText())));
                   else
                        listaHijos.get(position).setAños(0);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //    holder.añoset.setText(editModelArrayList.get(position).getEditTextValue());
    }

    @Override
    public int getItemCount() {
        return listaHijos.size();
    }

    public class ViewHolderHijos extends RecyclerView.ViewHolder {

        TextView edadtv;
        EditText añoset;


        public ViewHolderHijos(View itemView) {
            super(itemView);
            edadtv = (TextView) itemView.findViewById(R.id.textView9);
            añoset = itemView.findViewById(R.id.editText3);




        }



    }

}
