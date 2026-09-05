package com.socialchat.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private data class Chat(val name: String, val message: String, val online: Boolean)
private data class Message(val text: String, val mine: Boolean)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SocialChatApp() }
    }
}

@Composable
fun SocialChatApp() {
    var loggedIn by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var selectedChat by remember { mutableStateOf<String?>(null) }

    MaterialTheme {
        when {
            !loggedIn -> LoginScreen(email, { email = it }) { loggedIn = true }
            selectedChat != null -> ChatRoom(selectedChat!!) { selectedChat = null }
            else -> HomeScreen { selectedChat = it }
        }
    }
}

@Composable
private fun LoginScreen(email: String, onEmail: (String) -> Unit, onContinue: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Social Chat", style = MaterialTheme.typography.headlineLarge)
        Text("Connect • Chat • Share")
        Spacer(Modifier.height(24.dp))
        OutlinedTextField(email, onEmail, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(12.dp))
        Button(onClick = onContinue, enabled = email.isNotBlank(), modifier = Modifier.fillMaxWidth()) {
            Text("Continue")
        }
        Spacer(Modifier.height(8.dp))
        Text("Demo login for Step 2. Firebase authentication will replace this in the production build.")
    }
}

@Composable
private fun HomeScreen(onOpenChat: (String) -> Unit) {
    val chats = listOf(
        Chat("Welcome", "Welcome to Social Chat 👋", true),
        Chat("Ayesha", "Hey! How are you?", true),
        Chat("Rohan", "Let's chat later", false)
    )
    Scaffold(topBar = { TopAppBar(title = { Text("Social Chat") }) }) { padding ->
        LazyColumn(Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(16.dp)) {
            item { Text("Your Chats", style = MaterialTheme.typography.titleLarge); Spacer(Modifier.height(12.dp)) }
            items(chats) { chat ->
                Card(Modifier.fillMaxWidth().padding(bottom = 10.dp), onClick = { onOpenChat(chat.name) }) {
                    Row(Modifier.padding(16.dp)) {
                        Column(Modifier.weight(1f)) {
                            Text(chat.name, style = MaterialTheme.typography.titleMedium)
                            Text(chat.message)
                        }
                        Text(if (chat.online) "Online" else "Offline")
                    }
                }
            }
        }
    }
}

@Composable
private fun ChatRoom(name: String, onBack: () -> Unit) {
    var input by remember { mutableStateOf("") }
    val messages = remember {
        mutableStateListOf(
            Message("Hey! Welcome to Social Chat 👋", false),
            Message("Hi! Nice to meet you.", true)
        )
    }
    val listState = rememberLazyListState()
    Scaffold(
        topBar = { TopAppBar(title = { Text(name) }, navigationIcon = { TextButton(onClick = onBack) { Text("‹ Back") } }) },
        bottomBar = {
            Row(Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(input, { input = it }, placeholder = { Text("Type a message…") }, modifier = Modifier.weight(1f))
                Button(onClick = {
                    if (input.isNotBlank()) {
                        messages.add(Message(input.trim(), true))
                        input = ""
                    }
                }) { Text("Send") }
            }
        }
    ) { padding ->
        LaunchedEffect(messages.size) { if (messages.isNotEmpty()) listState.animateScrollToItem(messages.lastIndex) }
        LazyColumn(Modifier.fillMaxSize().padding(padding), state = listState, contentPadding = PaddingValues(12.dp)) {
            items(messages) { message ->
                Row(Modifier.fillMaxWidth(), horizontalArrangement = if (message.mine) Arrangement.End else Arrangement.Start) {
                    Card(Modifier.padding(vertical = 4.dp)) { Text(message.text, Modifier.padding(12.dp)) }
                }
            }
        }
    }
}
