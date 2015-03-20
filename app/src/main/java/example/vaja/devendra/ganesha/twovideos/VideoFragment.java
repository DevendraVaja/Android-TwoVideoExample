/**
 * Created by Devendra Vaja (devendra.vaja@gmail.com) on 3/20/15.
 * @author Devendra Vaja
 * This is a demo application to hold and play two videos at the same time
 */
package example.vaja.devendra.ganesha.twovideos;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;


public class VideoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        container = (RelativeLayout)inflater.inflate(R.layout.fragment_main, container, false);
        //locate the videoview in the layout
        VideoView videoView =(VideoView)container.findViewById(R.id.VideoView);
        //fetch the raw resource id for the raw resource identification
        String packageName = getActivity().getPackageName();
        String videoName = "small"; //NOTE: no extension here
        int id = getResources().getIdentifier(videoName, "raw", packageName);
        //make the URI path
        final String path = "android.resource://" + packageName + "/" + id;
        //Set the video to playback
        videoView.setVideoURI(Uri.parse(path));

        //Enable the video controller
        MediaController mediaController =new MediaController(inflater.getContext());
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        //Start the video
        videoView.start();

        return container;
    }

}
