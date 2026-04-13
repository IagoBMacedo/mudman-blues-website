document.addEventListener('DOMContentLoaded', () => {
    const albumSelect = document.getElementById('album');
    const langSelect = document.getElementById('language');
    const rows = document.querySelectorAll('.song-row');

    const filterSongs = () => {
        const selectedAlbum = albumSelect.value;
        const selectedLang = langSelect.value;

        rows.forEach(row => {
            // get the data from  attributes
            const rowAlbum = row.getAttribute('data-album');
            const rowLang = row.getAttribute('data-language');

            // show if all is selected or if it matches a specific value
            const albumMatch = (selectedAlbum === 'All' || rowAlbum === selectedAlbum);
            const langMatch = (selectedLang === 'All' || rowLang === selectedLang);

            if (albumMatch && langMatch) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    };

    albumSelect.addEventListener('change', filterSongs);
    langSelect.addEventListener('change', filterSongs);
});