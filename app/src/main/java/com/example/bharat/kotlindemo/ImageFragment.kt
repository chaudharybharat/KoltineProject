package mchehab.com.gridviewviewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.bharat.kotlindemo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_image.*


class ImageFragment : Fragment() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    public override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_image, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val imageURL = arguments.getString("imageURL")
        Picasso.with(activity)
                .load(imageURL)
                .into(imageView)
        return view
    }
}// Required empty public constructor
