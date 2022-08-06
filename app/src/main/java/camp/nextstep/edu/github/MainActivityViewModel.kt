package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.Github
import camp.nextstep.edu.github.domain.InjectGithubRepositoryData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 05..
 */
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val injectGithubRepositoryData: InjectGithubRepositoryData
) : ViewModel() {

    private var _updateGithub: MutableLiveData<List<Github>> =
        MutableLiveData(listOf())
    val updateGithub: LiveData<List<Github>>
        get() = _updateGithub

    fun loadGithub() {
        viewModelScope.launch {
            _updateGithub.value = injectGithubRepositoryData.execute()
        }
    }
}