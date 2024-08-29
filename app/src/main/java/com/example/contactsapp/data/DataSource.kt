package com.example.contactsapp.data

import androidx.compose.ui.res.stringResource
import com.example.contactsapp.R
import com.example.contactsapp.model.Contact

class DataSource {
    fun getContactsData():List<Contact>{
        val contacts = mutableListOf<Contact>()
        contacts.add(Contact("Auntie",
            R.drawable.auntie,
            "+201012345678")
        )
        contacts.add(Contact("Brother",
            R.drawable.brother,
            "+201123456789")
        )
        contacts.add(Contact("Daughter",
            R.drawable.daughter,
            "+201234567890")
        )
        contacts.add(Contact("Friend 1",
            R.drawable.friend_1,
            "+201345678901")
        )
        contacts.add(Contact("Friend 2",
            R.drawable.friend_2,
            "+20145678012")
        )
        contacts.add(Contact("Grandfather",
            R.drawable.grandfather,
            "+201567890123")
        )
        contacts.add(Contact("Granny",
            R.drawable.granny,
            "+201678901234")
        )
        contacts.add(Contact("Neighbour",
            R.drawable.neigbour,
            "+201789012345")
        )
        contacts.add(Contact("Sister",
            R.drawable.sister,
            "+201890123456")
        )
        contacts.add(Contact("Son",
            R.drawable.son,
            "+2019012345678")
        )
        contacts.add(Contact("Uncle",
            R.drawable.uncle,
            "+201512345678")
        )

     return contacts
    }


}