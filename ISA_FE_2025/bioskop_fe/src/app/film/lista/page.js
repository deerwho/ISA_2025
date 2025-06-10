'use client'
import {useEffect, useState} from "react";
import useListData from "@/hooks/useListData";
import DataTable from "react-data-table-component"
import {Spinner} from "reactstrap";

export const tableColumns = [
    {
        name: "Naziv",
        selector: (row)=>`${row.naziv}`,
        sortable: false,
    },
    {
        name: "Trajanje",
        selector: (row)=>`${row.trajanje}`,
        sortable: false,
    },
    {
        name: "Reziser",
        selector: (row)=>`${row.reziser}`,
        sortable: false,
    }
]

export default function listaFilmova() {
    const [pageNumber, setPageNumber] = useState(1);
    const [pageSize, setPageSize] = useState(5);
    const {getData, loading, data}=useListData(`film/vrati-sve-filmovePage?pageNumber=${pageNumber-1}&pageSize=${pageSize}`);

    useEffect(() => {
        getData(`film/vrati-sve-filmovePage?pageNumber=${pageNumber-1}&pageSize=${pageSize}`)
    }, [pageSize, pageNumber]);

    const handlePageChange = async (page) => {
        setPageNumber(page);
    };

    const handlePerRowsChange =async (newPerPage, page) => {
        setPageNumber(page);
        setPageSize(newPerPage);
    }

    console.log(data.filmovi);

    return (
        <>

            <DataTable data={data.filmovi}
                       columns={tableColumns}
                       striped={true}
                       noHeader={true}
                       pagination
                       paginationServer
                       progressPending={loading}
                       paginationTotalRows={data.totalElements}
                       onChangePage={handlePageChange}
                       onChangeRowsPerPage={handlePerRowsChange}
                       progressComponent={<Spinner color="danger">Ocitavanje...</Spinner>}
                       paginationPerPage={5}
                       highlightOnHover
            />


        </>)
}