class Post {
  constructor(title, link, author, img) {
    this.title = title;
    this.link = link;
    this.author = author;
    this.img = img;
  }
}

const app = new Vue ({
  el: '#app',
  data: {
    search: '',
    postList : [
      new Post(
        '풀업', 
        'https://www.youtube.com/watch?v=nWhS28U6bCY', 
        '바벨라토르', 
        'https://i.ytimg.com/an_webp/nWhS28U6bCY/mqdefault_6s.webp?du=3000&sqp=CMKGjowG&rs=AOn4CLB8TBFVIlPCjBP7ZgmOqS05hwqAlQ'
      ),
      new Post(
        '친업', 
        'https://www.youtube.com/watch?v=6GWGVAO8oU4', 
        '핏블리',
        'https://i.ytimg.com/an_webp/6GWGVAO8oU4/mqdefault_6s.webp?du=3000&sqp=CMT9jYwG&rs=AOn4CLB6SR4aRkUl6t73AI6rFSnts4Eqlg'
      ),
      new Post(
        '풀업VS친업', 
        'https://www.youtube.com/watch?v=1oIi0g363MI', 
        '피지컬갤러리', 
        'https://i.ytimg.com/an_webp/1oIi0g363MI/mqdefault_6s.webp?du=3000&sqp=CLaejowG&rs=AOn4CLBV0G7T0vXSlNncgp45JQ2CKhagxw'
      ),
      new Post(
        '푸쉬업', 
        'https://www.youtube.com/watch?v=-_DUjHxgmWk&t=1s', 
        '바벨라토르',
        'https://i.ytimg.com/an_webp/-_DUjHxgmWk/mqdefault_6s.webp?du=3000&sqp=CKbqjYwG&rs=AOn4CLDhgb20mKqBBiGmH_fliTXr8-DLkg'
      ),
      new Post(
        '25가지 푸쉬업', 
        'https://www.youtube.com/watch?v=Npx3ygB2eRY', 
        '데스런', 
        'https://img.youtube.com/vi/Npx3ygB2eRY/0.jpg'
      ),
      new Post(
        '싯업', 
        'https://www.youtube.com/watch?v=tfwbpv6gCbg', 
        '지피티',
        'https://i.ytimg.com/an_webp/tfwbpv6gCbg/mqdefault_6s.webp?du=3000&sqp=CIj-jYwG&rs=AOn4CLCapNSyx-UEE99ZoAPTrt-vFL2GIQ'
      ),
      new Post(
        '스쿼트', 
        'https://www.youtube.com/watch?v=QyAH8O5X6g0', 
        '강경원',
        'https://i.ytimg.com/an_webp/QyAH8O5X6g0/mqdefault_6s.webp?du=3000&sqp=CPOpjowG&rs=AOn4CLDHFWnxsKEis2bc355esrbksnzADA'
      ),
      new Post(
        '하체스트레칭', 
        'https://www.youtube.com/watch?v=UBVPNC1FBgc', 
        '피지컬갤러리', 
        'https://i.ytimg.com/an_webp/UBVPNC1FBgc/mqdefault_6s.webp?du=3000&sqp=CImRjowG&rs=AOn4CLD2vkjOq9kC0q5lP1Hw6zQD9ZxXRA'
      ),
      new Post(
        '상체스트레칭', 
        'https://www.youtube.com/watch?v=FsTkLYaUh_o', 
        '피지컬갤러리',
        'https://i.ytimg.com/an_webp/FsTkLYaUh_o/mqdefault_6s.webp?du=3000&sqp=CJybjowG&rs=AOn4CLAhP_wxQACUnrt7_nzw-NEJHoOcQw'
      ),
      new Post(
        '플랭크', 
        'https://youtu.be/Zq8nRY9P_cM', 
        '바벨라토르',
        'https://i.ytimg.com/an_webp/Zq8nRY9P_cM/mqdefault_6s.webp?du=3000&sqp=CLehjowG&rs=AOn4CLDylHTqPXJRCzD6qgAoFEq8KvTOSw'
      )
     
]
  },
  computed: {
    filteredList() {
      return this.postList.filter(post => {
        return post.title.toLowerCase().includes(this.search.toLowerCase())
      })
    }
  }
})