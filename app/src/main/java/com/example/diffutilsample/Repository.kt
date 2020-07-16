package com.example.diffutilsample

class Repository {
    private val employees = listOf( DetailsModal(1, "Jack","Nicholson"),
    DetailsModal(2, "Marlon" ,"Brando"),
    DetailsModal(3, "Robert De"," Niro"),
    DetailsModal(4, "Al","Pacino"),
    DetailsModal(5, "Daniel"," Day-Lewis"),
    DetailsModal(6, "Dustin","Hoffman"),
        DetailsModal(7, "Tom","Hanks"),
        DetailsModal(8, "Anthony"," Hopkins"),
        DetailsModal(9, "Paul","ewman"),
        DetailsModal(10, "Denzel"," Washington")
    )
    val detailsModalSortedbyId: List<DetailsModal>
    get() = employees.sortedByDescending{it.id  }

    val detailsModelSortedbyIdAsc :List<DetailsModal>
    get() = employees.sortedBy { it.id }

    val detailsModalSortbyName :List<DetailsModal>
    get() = employees.sortedBy { it.firstname }

    val firstFive :List<DetailsModal>
    get() = employees.subList(1,4)

fun idSort():List<DetailsModal>{
    return employees.sortedByDescending { it.id }
}

}