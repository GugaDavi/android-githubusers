package com.example.githubusers.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.R
import com.example.githubusers.databinding.UserListBinding
import com.google.android.material.divider.MaterialDividerItemDecoration

class UserListFragment : Fragment() {
  private var binding: UserListBinding? = null
  private lateinit var adapter: UserListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    adapter = UserListAdapter()
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = UserListBinding.inflate(inflater, container, false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding?.usersRecyclerView?.layoutManager = LinearLayoutManager(requireContext())
    binding?.usersRecyclerView?.adapter = adapter

    addDividerSpace()

    adapter.updateUserList(
      listOf(
        User(
          "diego3g",
          "https://github.com/diego3g",
          "Diego Fernandes",
          "https://avatars.githubusercontent.com/u/2254731?v=4",
        ),
        User(
          "diego3g",
          "https://github.com/diego3g",
          "Diego Fernandes",
          "https://avatars.githubusercontent.com/u/2254731?v=4",
        ),
        User(
          "diego3g",
          "https://github.com/diego3g",
          "Diego Fernandes",
          "https://avatars.githubusercontent.com/u/2254731?v=4",
        ),
        User(
          "diego3g",
          "https://github.com/diego3g",
          "Diego Fernandes",
          "https://avatars.githubusercontent.com/u/2254731?v=4",
        ),
        User(
          "diego3g",
          "https://github.com/diego3g",
          "Diego Fernandes",
          "https://avatars.githubusercontent.com/u/2254731?v=4",
        )
      )
    )
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }

  private fun addDividerSpace() {
    val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)

    divider.isLastItemDecorated = false

    val src = requireContext().resources

    divider.dividerInsetStart = src.getDimensionPixelSize(R.dimen.m)

    divider.dividerThickness = src.getDimensionPixelSize(R.dimen.divider)
    divider.dividerColor = ContextCompat.getColor(requireContext(), R.color.black)

    binding?.usersRecyclerView?.addItemDecoration(divider)
  }
}