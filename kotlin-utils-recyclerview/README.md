The utils class use for recycler-view which is simple but useful and powerful.

There are 2 type of Adapter with just around 20 lines of kotlin code the `GenericAdapter` and `GenericMultiItemAdapter`

## Goal

The adapter is the binder between recyclerview and your data. But sometimes the adapter just need way more information 
than just the dataset itself. For example we want click an item in the recyclerview to open an Activity which normally 
we need to pass an Activty instance as a interface into that adapter:

```kotlin

class MainActivity : AppCompatActivity(),Click {
    
    override fun onClick() {
        //open your activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = ClickAdapter(this,dataSet)
    }


}

interface Click {
    fun onClick()
}

```
And then bind your click interface inside the adapter.

An adapter shouldn't know that much of infomations. 
With `GenericeAdapter` you can just bind your view and data inside your activity for example:

```
        recyclerView.adapter = GenericAdapter(R.layout.item, listOf("1", "2", "3")) { item, position ->
        //here you're inside the ViewHolder Context.
            itemView.setOnClickListener {
                //open the detail activity
            }
            textview.text = item
        }
```

You can also use the `GenericMultiItemAdapter` to bind the multi-type dataset and layout resource.  


