package com.example.fasol.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fasol.*
import retrofit2.Call
import retrofit2.Response

class Products : Fragment(R.layout.fragment_products) {

    private lateinit var title: TextView
    private lateinit var recycle: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_products, container, false)
        title = v.findViewById(R.id.subcategory_Title)
        recycle = v.findViewById(R.id.products_view)
        if (arguments != null) {
            val bundle = requireArguments()
            title.text = bundle.getString("name")

            RetrofitClient.instance.getProducts(bundle.getInt("subcatId"))
                .enqueue(object : retrofit2.Callback<ProductsModel> {

                    override fun onResponse(
                        call: Call<ProductsModel>,
                        response: Response<ProductsModel>
                    ) {
                        if (response.code() == 200) {
                            val adapter =
                                ProductAdapter(response.body()?.results as ArrayList<ProductFromAll>, parentFragmentManager)
                            recycle.adapter = adapter

                            recycle.setHasFixedSize(true)
                            recycle.layoutManager =
                                GridLayoutManager(requireContext().applicationContext, 2)
                        } else
                            Toast.makeText(
                                context,
                                "Что-то пошло не так! ${response.code()} ${response.body()}",
                                Toast.LENGTH_SHORT
                            )
                    }

                    override fun onFailure(call: Call<ProductsModel>, t: Throwable) {
                        Toast.makeText(context, "Что-то пошло не так!", Toast.LENGTH_SHORT)
                    }

                })


        }

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}