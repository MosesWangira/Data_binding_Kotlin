package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding : ActivityMainBinding

    private val myModel : Model = Model("Hello @altruism Stunning!!")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.model = myModel
        myModel.wife = "Hello.. You are valued"

    }
}

/*
* These are the simple steps to data binding
* */

// 1. Enable dataBinding in build.gradle (module: app)
//    below build types add this
//     dataBinding{
//        enabled = true
//    }
//    sync project
//
// 2. In your layout file add layout tag and copy the xmlns such that the layout is the root
//    and all other views and view groups are in it
//
// 3. add the data and variable below layout
//    i.e
//    <data>
//        <variable
//            name="model"
//            type="com.example.databinding.Model" />
//    </data>
//    this is done in the layout file
// 4. Create a kotlin class and in it declare your variables
//    i.e
//    class Model (var name : String = "",
//             var wife : String = "")
// 5. Rename the value of text attribute in layout file
//    i.e
//    for android:text= "altruism" becomes
//    android:text= "@={model.name}"
//    do this for all texts you want to perform binding with
//    model refers to this declared here
//     <data>
//        <variable
//           name="model"
//           type="com.example.databinding.Model" />
//     </data>
//    type is the package name for the Kotlin class created.

//    In the Kotlin class which represent layout you performed the task above e.g MainActivity for activity_main
// 6. Create variable for binding object above onCreate
//    e.g private lateinit var dataBinding : ActivityMainBinding
//    create instance of binding class above onCreate
//    private val myModel : Model = Model("Hello @altruism Stunning!!")
//
//    the ActivityMainBinding is generated for you according to the class you are working with
//    setContentView using the DataBindingUtil i.e
//    DataBindingUtil.setContentView(context(use this), R.layout.activity_main)
//
//    dataBinding.model = myModel
//
//    use the instantiated object to access and define the other variables
//    myModel.wife = "Hello.. You are valued"