package nt.vn.mentorconnect

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
Toast.makeText(this,"This is admin dashboard",Toast.LENGTH_LONG).show()
        // Card listeners for navigation actions
        val cardAddSkills: CardView = findViewById(R.id.cardAddSkills)
        val cardViewMentees: CardView = findViewById(R.id.cardViewMentees)
        val cardReviewProgress: CardView = findViewById(R.id.cardReviewProgress)
        val cardViewReports: CardView = findViewById(R.id.cardViewReports)

        cardAddSkills.setOnClickListener {
            // Navigate to Add Skills Activity
            /*val intent = Intent(this, AddSkillsActivity::class.java)
            startActivity(intent)*/
        }

        cardViewMentees.setOnClickListener {
            // Navigate to View Mentees Activity
            val pb=ProgressDialog(this)
            pb.show()
            val intent = Intent(this, CommunityManagerDashboard::class.java)
            intent.putExtra("userType","MENTEE")
            startActivity(intent)

        }

        cardReviewProgress.setOnClickListener {
            // Navigate to Review Progress Activity
            /*val intent = Intent(this, ReviewProgressActivity::class.java)
            startActivity(intent)*/
        }

        cardViewReports.setOnClickListener {
            // Navigate to View Reports Activity
           /* val intent = Intent(this, ViewReportsActivity::class.java)
            startActivity(intent)*/
        }
    }
}
