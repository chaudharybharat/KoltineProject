package mchehab.com.gridviewviewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.bharat.kotlindemo.R
import com.squareup.picasso.Picasso

/**
 * Created by muhammadchehab on 12/8/17.
 */
class GridViewAdapter(val context: Context, val listImageURLs: List<String>): BaseAdapter() {

    override fun getItem(position: Int): Any {
        return listImageURLs[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return listImageURLs.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null)
            viewHolder = ViewHolder()
            viewHolder.imageView = convertView.findViewById(R.id.imageView)
            convertView.tag = viewHolder
        }else{
            viewHolder = convertView.tag as ViewHolder
        }

        Picasso.with(context)
                .load(listImageURLs[position])
                .into(viewHolder.imageView)

        return convertView!!
    }

    class ViewHolder{
        lateinit var imageView: ImageView
    }
}