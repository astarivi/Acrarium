/*
 * (C) Copyright 2021-2023 Lukas Morawietz (https://github.com/F43nd1r)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.faendir.acra.ui.component.grid

import com.faendir.acra.i18n.Messages
import com.faendir.acra.ui.component.PopupButton
import com.faendir.acra.ui.component.Translatable
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.VerticalLayout

class GridFilterMenu(private val grid: LayoutPersistingFilterableGrid<*, *, *, *>) : PopupButton(VaadinIcon.FILTER) {
    private val content = VerticalLayout().also {
        it.style.set("background-color", "var(--lumo-shade-5pct)")
        add(it)
    }

    init {
        update()
    }

    fun update() {
        content.removeAll()
        content.add(Translatable.createLabel(Messages.FILTER).with {
            style.set("font-weight", "bold")
        })
        content.add(*grid.filterableColumns.mapNotNull { it.filterComponent }.toTypedArray())
    }
}