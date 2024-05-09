const prevButton = document.querySelector('.prev-banner');
    const nextButton = document.querySelector('.next-banner');
    const banners = document.querySelectorAll('.container img');
    let currentBannerIndex = 0;

    nextButton.addEventListener('click', () => {
        banners[currentBannerIndex].style.display = 'none';
        currentBannerIndex = (currentBannerIndex + 1) % banners.length;
        banners[currentBannerIndex].style.display = 'block';
    });

    prevButton.addEventListener('click', () => {
        banners[currentBannerIndex].style.display = 'none';
        currentBannerIndex = (currentBannerIndex - 1 + banners.length) % banners.length;
        banners[currentBannerIndex].style.display = 'block';
    });