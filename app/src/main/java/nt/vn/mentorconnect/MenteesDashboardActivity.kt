package nt.vn.mentorconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import nt.vn.mentorconnect.models.User

class MenteesDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentees_dashboard)
        val menteeName:TextView=findViewById(R.id.menteeName)
        FirebaseDatabase.getInstance().reference.child("users").child(FirebaseAuth.getInstance().currentUser!!.uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(userSnapshot: DataSnapshot) {
                    val id = userSnapshot.child("id").value.toString()
                    val name = userSnapshot.child("name").value.toString()
                    val email = userSnapshot.child("email").value.toString()
                    val role = userSnapshot.child("role").value.toString()
                    val isactive = userSnapshot.child("active").value.toString()
                    val user= User(id,name,email,role,isactive.toBoolean())
                    if (user != null) {
                        menteeName.text=user.email
                    }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }
}