package com.project.faily.ui.gallery





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.gallery.GalleryListener
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.login.LoginListener

class GalleryViewModel: ViewModel(){
    var galleryListener: GalleryListener? = null
}