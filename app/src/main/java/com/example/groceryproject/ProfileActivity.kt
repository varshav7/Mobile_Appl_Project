package com.example.groceryproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ProfileActivity : AppCompatActivity() {

    private lateinit var profileImageView: ImageView
    private lateinit var btnTakePicture: Button
    private lateinit var btnSaveChanges: Button
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etEmail: EditText
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton

    private val CAMERA_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        profileImageView = findViewById(R.id.profileImageView)
        btnTakePicture = findViewById(R.id.btnTakePicture)
        btnSaveChanges = findViewById(R.id.btnSaveChanges)
        etName = findViewById(R.id.editTextText)
        etAge = findViewById(R.id.editTextText2)
        etEmail = findViewById(R.id.editTextText3)
        rbMale = findViewById(R.id.male)
        rbFemale = findViewById(R.id.female)

        loadProfileFromFile()
        loadProfileImage()

        btnTakePicture.setOnClickListener {
            openCamera()
        }

        btnSaveChanges.setOnClickListener {
            saveProfileToFile()
            Toast.makeText(this, "Profile saved!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            profileImageView.setImageBitmap(imageBitmap)
            saveProfileImage(imageBitmap)
        } else {
            Toast.makeText(this, "Failed to capture image", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveProfileToFile() {
        val profileData = "${etName.text}\n${etAge.text}\n${etEmail.text}\n${if (rbMale.isChecked) "Male" else "Female"}"
        try {
            val file = File(filesDir, "profile_data.txt")
            file.writeText(profileData)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun loadProfileFromFile() {
        val file = File(filesDir, "profile_data.txt")
        if (!file.exists()) return

        val data = file.readLines()
        if (data.size >= 4) {
            etName.setText(data[0])
            etAge.setText(data[1])
            etEmail.setText(data[2])
            if (data[3] == "Male") rbMale.isChecked = true else rbFemale.isChecked = true
        }
    }

    private fun saveProfileImage(bitmap: Bitmap) {
        val file = File(filesDir, "profile_picture.jpg")
        try {
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun loadProfileImage() {
        val file = File(filesDir, "profile_picture.jpg")
        if (file.exists()) {
            val bitmap = BitmapFactory.decodeFile(file.absolutePath)
            profileImageView.setImageBitmap(bitmap)
        }
    }
}
