package co.nimblehq.chorn.survey.ui.screens.home

import co.nimblehq.chorn.survey.ui.base.BaseViewModel
import co.nimblehq.chorn.survey.util.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    dispatchers: DispatchersProvider
) : BaseViewModel(dispatchers)
