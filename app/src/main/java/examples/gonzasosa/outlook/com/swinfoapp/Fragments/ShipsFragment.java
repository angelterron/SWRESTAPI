package examples.gonzasosa.outlook.com.swinfoapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import examples.gonzasosa.outlook.com.swinfoapp.Models.SWApiStarShip;
import examples.gonzasosa.outlook.com.swinfoapp.Models.SWApiStarShipsHeader;
import examples.gonzasosa.outlook.com.swinfoapp.R;
import examples.gonzasosa.outlook.com.swinfoapp.Utils.DownloadAsyncTask;
import examples.gonzasosa.outlook.com.swinfoapp.Utils.URLS;

public class ShipsFragment extends Fragment {
    ArrayList<SWApiStarShip> foo = new ArrayList<>();
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_baseapi, container, false);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentActivity activity = getActivity ();
        if (activity == null) return;

        recyclerView = activity.findViewById (R.id.baseApiList);
        recyclerView.setLayoutManager (new LinearLayoutManager(getActivity ()));
        new DownloadAsyncTask(this::parseJSON).execute (URLS.SW_API_STARSHIPS_URL);
    }
    private void parseJSON (String json) {
        SWApiStarShipsHeader ships = new Gson().fromJson (json, SWApiStarShipsHeader.class);
        if (ships == null) return;
        if (ships.next != null) {
            new DownloadAsyncTask (this::parseJSON).execute (ships.next);
        } else {
            foo.addAll (ships.results);
            recyclerView.setAdapter (new shipAdapter(foo));
        }

        foo.addAll (ships.results);
    }
    class shipAdapter extends RecyclerView.Adapter<shipAdapter.shipViewHolder> {

        private ArrayList<SWApiStarShip> data;

        shipAdapter (ArrayList<SWApiStarShip> d) {
            data = d;
        }

        @NonNull
        @Override
        public shipViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from (parent.getContext ());
            View view = inflater.inflate (R.layout.list_item, parent, false);

            return new shipViewHolder (view);
        }

        @Override
        public void onBindViewHolder (@NonNull shipViewHolder holder, int position) {
            SWApiStarShip ship = data.get (position);
            holder.setData (ship.name,"Modelo: ", ship.model, "Capacidad de carga: ",ship.cargo_capacity);
        }

        @Override
        public int getItemCount () {
            return data.size ();
        }

        class shipViewHolder extends RecyclerView.ViewHolder {
            TextView tvData1, tvData2, tvData3,tvData4, tvData5;

            shipViewHolder (View itemView) {
                super (itemView);

                tvData1 = itemView.findViewById (R.id.tvData1);
                tvData2 = itemView.findViewById (R.id.tvData2);
                tvData3 = itemView.findViewById (R.id.tvData3);
                tvData4 = itemView.findViewById (R.id.tvData4);
                tvData5 = itemView.findViewById (R.id.tvData5);
            }

            void setData (String data1, String data2, String data3,String data4, String data5) {
                tvData1.setText (data1);
                tvData2.setText (data2);
                tvData3.setText (data3);
                tvData4.setText (data4);
                tvData5.setText (data5);
            }
        }
    }
}
