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

import examples.gonzasosa.outlook.com.swinfoapp.Models.SWApiFIlmsHeader;
import examples.gonzasosa.outlook.com.swinfoapp.Models.SWApiFilm;
import examples.gonzasosa.outlook.com.swinfoapp.R;
import examples.gonzasosa.outlook.com.swinfoapp.Utils.DownloadAsyncTask;
import examples.gonzasosa.outlook.com.swinfoapp.Utils.URLS;

public class FilmFragment extends Fragment {
    ArrayList<SWApiFilm> foo = new ArrayList<>();
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
        new DownloadAsyncTask(this::parseJSON).execute (URLS.SW_API_FILMS);
    }
    private void parseJSON (String json) {
        SWApiFIlmsHeader films = new Gson().fromJson (json, SWApiFIlmsHeader.class);
        if (films == null) return;
        if (films.next != null) {
            new DownloadAsyncTask (this::parseJSON).execute (films.next);
        } else {
            foo.addAll (films.results);
            recyclerView.setAdapter (new filmAdapter(foo));
        }

        foo.addAll (films.results);
    }
    class filmAdapter extends RecyclerView.Adapter<filmAdapter.filmViewHolder> {

        private ArrayList<SWApiFilm> data;

        filmAdapter (ArrayList<SWApiFilm> d) {
            data = d;
        }

        @NonNull
        @Override
        public filmViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from (parent.getContext ());
            View view = inflater.inflate (R.layout.list_item, parent, false);

            return new filmViewHolder (view);
        }

        @Override
        public void onBindViewHolder (@NonNull filmViewHolder holder, int position) {
            SWApiFilm film = data.get (position);
            holder.setData (film.title, "Episodio: ",film.episode_id, "Director: ",film.director);
        }

        @Override
        public int getItemCount () {
            return data.size ();
        }

        class filmViewHolder extends RecyclerView.ViewHolder {
            TextView tvData1, tvData2, tvData3,tvData4,tvData5;

            filmViewHolder (View itemView) {
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
