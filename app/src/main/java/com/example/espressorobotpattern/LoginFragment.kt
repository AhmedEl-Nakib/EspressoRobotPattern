package com.example.espressorobotpattern

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.espressorobotpattern.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    lateinit var binding : LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtnId.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog(){
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle("Dialog Title")
        dialog.setMessage("Are you want to login ?")
        dialog.setPositiveButton("Yes") { p0, p1 ->
            binding.progressBar.visibility = View.VISIBLE
            Toast.makeText(requireContext(),"Yes Clicked",Toast.LENGTH_SHORT).show()
        }
        dialog.setNegativeButton("Cancel") { p0, p1 ->
            Toast.makeText(requireContext(),"Negative Message",Toast.LENGTH_SHORT).show()
        }
        dialog.create().show()

    }

}