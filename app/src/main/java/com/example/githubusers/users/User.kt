package com.example.githubusers.users

data class User(
  val nickname: String,
  val url: String,
  val name: String,
  val avatar: String? = null,
  val repos: List<UserCodeRepository>? = null
)

data class UserCodeRepository(
  val name: String,
  val description: String,
  val url: String,
)
