package com.example.githubusers.users

import android.os.StrictMode
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.databinding.UserBinding
import com.example.githubusers.utils.ImageUtils

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
  private val asyncListDiffer: AsyncListDiffer<User> = AsyncListDiffer(this, DiffCallback)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val binding = UserBinding.inflate(layoutInflater, parent, false)
    StrictMode
      .setThreadPolicy(StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())

    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(asyncListDiffer.currentList[position])
  }

  override fun getItemCount(): Int = asyncListDiffer.currentList.size

  class ViewHolder(
    private val binding: UserBinding,
  ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
      binding.name.text = user.name
      binding.nickname.text = user.nickname

      val avatarBitMap = ImageUtils.getRemoteImage(user.avatar)

      if (avatarBitMap != null) {
        binding.avatar.setImageBitmap(avatarBitMap)
      }

      binding.viewProfileButton.setOnClickListener(fun(view) {
        view.findNavController().navigate(R.id.action_UsersListFragmentId_to_ReposListFragmentId)
      })
    }
  }

  fun updateUserList(users: List<User>) {
    asyncListDiffer.submitList(users)
  }

  object DiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
      return oldItem.nickname == newItem.nickname
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
      return oldItem == newItem
    }
  }
}