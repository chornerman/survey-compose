package co.nimblehq.chorn.survey.ui.screens.home

import co.nimblehq.chorn.survey.domain.usecase.UseCase
import co.nimblehq.chorn.survey.model.UiModel
import co.nimblehq.chorn.survey.model.toUiModels
import co.nimblehq.chorn.survey.ui.base.BaseViewModel
import co.nimblehq.chorn.survey.util.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: UseCase,
    dispatchers: DispatchersProvider
) : BaseViewModel(dispatchers) {

    private val _uiModels = MutableStateFlow<List<UiModel>>(emptyList())
    val uiModels: StateFlow<List<UiModel>>
        get() = _uiModels

    init {
        execute {
            showLoading()
            useCase()
                .catch {
                    _error.emit(it)
                }
                .collect { result ->
                    val uiModels = result.toUiModels()
                    _uiModels.emit(uiModels)
                }
            hideLoading()
        }
    }
}
