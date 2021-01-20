package com.example.recyclerviewexampleclass157_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewexampleclass157_2.databinding.WordItemListBinding;

import java.util.List;
                                    //3. Extender de Recycler.Adapter, pasar el ViewHolder creado
                                    // 4. Implementar los métodos. oncreateViewHolder, onBind y getitemcount
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    //1. Añadir una representacion de los datos.
    private List<String> mWordList;

    //8. No olvidar crear el Constructor para pasar el listado de datos al instanciar el adapter
    public WordAdapter(List<String> mWordList) {
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //6. instanciamos ViewBinding para retornar nuestro ViewHolder con esa dependencia.
        WordItemListBinding mBinding = WordItemListBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WordViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        //7. Creamos una variable de referencia de contenido de el listado y lo asignamos al elemento
        //visual que viene en el holder.
        String element = mWordList.get(position);//esto indica la poscion del click
        holder.textView.setText(element);// luego se lo indicamos al textview.
    }

    @Override
    public int getItemCount() {
        //5. Indicar la cantidad de datos a mostrar
        return mWordList.size();
    }


    //2. Crear clase interna ViewHolder
    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;

        public WordViewHolder(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView = mBinding.textView;
            itemView.setOnClickListener(this); //indicar que hay un setonclicklistener no olvidar
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String seleccionado = mWordList.get(position);
            Toast.makeText(v.getContext(), seleccionado, Toast.LENGTH_SHORT).show();// esto saca una
            //pantallita que muestra la palabra que esta siendo seleccionada

        }
    }


}
